/**
 * Author Eugene Brown
App: UserList
Class: MockResponseFileReader
Usage: Reads json file
 **/
package com.example.userlist.viewmodel

import java.io.FileNotFoundException
import java.io.InputStreamReader

class MockResponseFileReader() {
  fun readStringFromFile(path: String): String {

  val classLoader = this.javaClass.classLoader

    if (classLoader != null) {
      try {
    val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path),
      "UTF-8")
        val builder = StringBuilder()
        reader.readLines().forEach {
          builder.append(it)
          reader.close()
        }
        return builder.toString()


      } catch (e: FileNotFoundException) {
        println("Could not find the specified file: $path")
        throw e
      }
    } else {
      throw IllegalStateException(
        """Classloader is null. Can't open an inputstream for the specified file:
          | $path without it.""".trimMargin()
      )
    }
  }

}