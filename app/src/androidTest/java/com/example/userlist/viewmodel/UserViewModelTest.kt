package com.example.userlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.userlist.model.Repository
import com.example.userlist.model.chars.Characters
import com.example.userlist.model.comics.Comic
import com.example.userlist.model.retrofitAPI.RetrofitService
import com.example.userlist.viewmodel.util.getOrAwaitValue
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@RunWith(AndroidJUnit4::class)
class UserViewModelTest {
  private val mockWebServer = MockWebServer()

  @ExperimentalCoroutinesApi
  @get:Rule
  val coroutineTestRule = TestCoroutineRule()

  @get:Rule
  var rule: TestRule = InstantTaskExecutorRule()

  private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.BODY
  }
  private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

  private var api = Retrofit.Builder()
    .baseUrl(mockWebServer.url("/"))
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(RetrofitService::class.java)

  private val characters: String = MockResponseFileReader().readStringFromFile("charTest.json")
  private val comics: String = MockResponseFileReader().readStringFromFile("comicTest.json")
  private val id = 1011334

  @MockK
  private lateinit var repository: Repository

  @InjectMockKs
  private lateinit var userViewModel: UserViewModel


  private lateinit var code: String

  private lateinit var mockServResponse: MockResponse// = MockResponse().setBody(reader)

  @ExperimentalCoroutinesApi
  @Before
  fun setUp() {
    MockKAnnotations.init(this, relaxed = true)
  }

  @After
  fun tearDown() {
    mockWebServer.shutdown()
  }

  @Test
  fun testGetRepositoryCharsResponse200() {
    mockServResponse = MockResponse().setBody(characters)
    mockWebServer.enqueue(mockServResponse)

    @MockK
    val repository = mockk<Repository> { Repository(api) }

    val gson = Gson()
    val chars = gson.fromJson(characters, Characters::class.java)
    coEvery {
      repository.getAllChar()
    } returns Response.success(chars)

    runBlocking {
      repository.getAllChar()
      code = repository.getAllChar().body()!!.code

    }
    coVerify { repository.getAllChar() }
    Assert.assertEquals("200", code)

  }

  @Test
  fun testGetRepositoryComicsResponse200() {
    mockServResponse = MockResponse().setBody(comics)
    mockWebServer.enqueue(mockServResponse)

    @MockK
    val repository = mockk<Repository> { Repository(api) }

    val gson = Gson()
    val comic = gson.fromJson(comics, Comic::class.java)
    coEvery {
      repository.getAllComics(id)
    } returns Response.success(comic)

    runBlocking {
      repository.getAllComics(id)
      code = repository.getAllComics(id).body()!!.code

    }
    coVerify { repository.getAllComics(id) }
    Assert.assertEquals("200", code)

  }

  @Test
  fun isLiveDataCharactersEmitting_getOrAwaitValue() {
    mockServResponse = MockResponse().setBody(characters)
    mockWebServer.enqueue(mockServResponse)

    repository = Repository(api)
    userViewModel = UserViewModel(repository)
    userViewModel.getAllUsers()
    // Pass:
    assertEquals("3-D Man", userViewModel.charList.getOrAwaitValue()[0].name)

  }

  @Test
  fun isLiveDataComicsEmitting_getOrAwaitValue() {
    mockServResponse = MockResponse().setBody(comics)
    mockWebServer.enqueue(mockServResponse)

    repository = Repository(api)
    userViewModel = UserViewModel(repository)
    userViewModel.getAllComics(1011334)
    // Pass:
    assertEquals("jpg", userViewModel.comicList.getOrAwaitValue()[0].thumbnail.extension)

  }
}

