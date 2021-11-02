package com.example.userlist.viewmodel.util

import com.example.userlist.model.chars.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class TestComicObjects() {

   //fun getAllChars() = retrofitService.repositoryData()

  fun getCharsMockResponse():Result {

    val expected =
      Result(
        id = "1011334",
        name = "3-D Man",
        description = "",
        thumbnail = Thumbnail(
          "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
          "jpg"
        ),
        comics = Comics(
          " 12",
          "http://gateway.marvel.com/v1/public/characters/1011334/comics",
          items = listOf(
            Item(
              "Avengers: The Initiative (2007) #14",
              "http://gateway.marvel.com/v1/public/comics/21366"
            ),
            Item(
              "Avengers: The Initiative (2007) #14 (SPOTLIGHT VARIANT)",
              "http://gateway.marvel.com/v1/public/comics/24571"
            ),
            Item(
              "Avengers: The Initiative (2007) #15",
              "http://gateway.marvel.com/v1/public/comics/21546"
            ),
            Item(
              "Avengers: The Initiative (2007) #16",
              "http://gateway.marvel.com/v1/public/comics/21741"
            ),
            Item(
              "Avengers: The Initiative (2007) #17",
              "http://gateway.marvel.com/v1/public/comics/21975"
            ),
            Item(
              "Avengers: The Initiative (2007) #18",
              "http://gateway.marvel.com/v1/public/comics/22299"
            ),
            Item(
              "Avengers: The Initiative (2007) #18 (ZOMBIE VARIANT)",
              "http://gateway.marvel.com/v1/public/comics/22300"
            ),
            Item(
              "Avengers: The Initiative (2007) #19",
              "http://gateway.marvel.com/v1/public/comics/22506"
            ),
            Item(
              "Deadpool (1997) #44",
              "http://gateway.marvel.com/v1/public/comics/8500"
            ),
            Item(
              "Marvel Premiere (1972) #35",
              "http://gateway.marvel.com/v1/public/comics/10223"
            ),
            Item(
              "Marvel Premiere (1972) #36",
              "http://gateway.marvel.com/v1/public/comics/10224"
            ),
            Item(
              "Marvel Premiere (1972) #37",
              "http://gateway.marvel.com/v1/public/comics/10225"
            )
          ), "12"
        ),
        events = Events(
          "1",
          "http://gateway.marvel.com/v1/public/characters/1011334/events",
          items = listOf(
            ItemX(
              "Secret Invasion",
              "http://gateway.marvel.com/v1/public/events/269"
            )
          ), "1"
        ),
        modified = "2014-04-29T14:18:17-0400",
        resourceURI = "http://gateway.marvel.com/v1/public/characters/1011334",
        series = Series(
          "3",
          "http://gateway.marvel.com/v1/public/characters/1011334/series",
          listOf(
            ItemXX(
              "Avengers: The Initiative (2007 - 2010)",
              "http://gateway.marvel.com/v1/public/series/1945"
            ),
            ItemXX(
              "Deadpool (1997 - 2002)",
              "http://gateway.marvel.com/v1/public/series/2005",
            ),
            ItemXX(
              "Marvel Premiere (1972 - 1981)",
              "http://gateway.marvel.com/v1/public/series/2045"
            )
          ), "3"
        ),
        stories = Stories(
          "21",
          "http://gateway.marvel.com/v1/public/characters/1011334/stories",
          listOf(
            ItemXXX(
              "Cover #19947",
              "http://gateway.marvel.com/v1/public/stories/19947",
              "cover"
            ),
            ItemXXX(
              "The 3-D Man!",
              "http://gateway.marvel.com/v1/public/stories/19948",
              "interiorStory"
            ),
            ItemXXX(
              "Cover #19949",
              "http://gateway.marvel.com/v1/public/stories/19949",
              "cover"
            ),
            ItemXXX(
              "The Devil's Music!",
              "http://gateway.marvel.com/v1/public/stories/19950",
              "interiorStory"
            ),
            ItemXXX(
              "Cover #19951",
              "http://gateway.marvel.com/v1/public/stories/19951",
              "cover"
            ),
            ItemXXX(
              "Code-Name:  The Cold Warrior!",
              "http://gateway.marvel.com/v1/public/stories/19952",
              "interiorStory"
            ),
            ItemXXX(
              "AVENGERS: THE INITIATIVE (2007) #14",
              "http://gateway.marvel.com/v1/public/stories/47184",
              "cover"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #14 - Int",
              "http://gateway.marvel.com/v1/public/stories/47185",
              "interiorStory"
            ),
            ItemXXX(
              "AVENGERS: THE INITIATIVE (2007) #15",
              "http://gateway.marvel.com/v1/public/stories/47498",
              "cover"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #15 - Int",
              "http://gateway.marvel.com/v1/public/stories/47499",
              "interiorStory"
            ),
            ItemXXX(
              "AVENGERS: THE INITIATIVE (2007) #16",
              "http://gateway.marvel.com/v1/public/stories/47792",
              "cover"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #16 - Int",
              "http://gateway.marvel.com/v1/public/stories/47793",
              "interiorStory"
            ),
            ItemXXX(
              "AVENGERS: THE INITIATIVE (2007) #17",
              "http://gateway.marvel.com/v1/public/stories/48361",
              "cover"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #17 - Int",
              "http://gateway.marvel.com/v1/public/stories/48362",
              "interiorStory"
            ),
            ItemXXX(
              "AVENGERS: THE INITIATIVE (2007) #18",
              "http://gateway.marvel.com/v1/public/stories/49103",
              "cover"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #18 - Int",
              "http://gateway.marvel.com/v1/public/stories/49104",
              "interiorStory"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #18, Zombie Variant - Int",
              "http://gateway.marvel.com/v1/public/stories/49106",
              "interiorStory"
            ),
            ItemXXX("AVENGERS: THE INITIATIVE (2007) #19",

              "http://gateway.marvel.com/v1/public/stories/49888",
              "cover"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #19 - Int",
              "http://gateway.marvel.com/v1/public/stories/49889",
              "interiorStory"
            ),
            ItemXXX(
              "Avengers: The Initiative (2007) #14, Spotlight Variant - Int",
              "http://gateway.marvel.com/v1/public/stories/54371",
              "interiorStory"
            )

          ), "20"
        ),

        urls = listOf(
          Url(
            "detail",
            "http://marvel.com/characters/76/a-bomb?utm_campaign=apiRef&utm_source=1f0a213d259b0f11725a6ae8e54cc537"
          ),
          Url(
            "wiki",
            "http://marvel.com/universe/3-D_Man_(Chandler)?utm_campaign=apiRef&utm_source=1f0a213d259b0f11725a6ae8e54cc537"
          ),
          Url(
            "comiclink",
            "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=1f0a213d259b0f11725a6ae8e54cc537"
          )
        )
      )

    return expected
  }
}

