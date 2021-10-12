# User_List
Grabs data from the Marvel API
## Description
<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="https://user-images.githubusercontent.com/2469698/137003352-2c4f88a6-4033-4450-9c88-a149248e7f61.png" width="400" height="700"></td>
   <td><img src="https://user-images.githubusercontent.com/2469698/137003675-664f9e53-8274-42d4-aea9-f0237b62dacd.png" width="400" height="700"></td>
  </tr>
 </table>
### The Marvel API
Building an application based on Marvel API.



## Getting Started

### Dependencies

     // viewmodel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    implementation "androidx.lifecycle:lifecycle-runtime:2.3.1"
    implementation "androidx.lifecycle:lifecycle-common:2.3.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"

    // fragments
    implementation "androidx.fragment:fragment-ktx:$fragments_version"

    //Recyclerview
    implementation "androidx.recyclerview:recyclerview:1.2.1"

    //Retrofit
    implementation 'com.google.code.gson:gson:2.8.6'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.squareup.retrofit2:converter-moshi:2.6.2"

    //ok http intercepter
    implementation 'com.squareup.okhttp3:logging-interceptor:4.7.2'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    implementation 'com.github.bumptech.glide:compiler:4.12.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'

    //expresso
    androidTestImplementation('androidx.test.espresso:espresso-core:3.4.0')
    androidTestImplementation('androidx.test:runner:1.4.0')
    androidTestImplementation('androidx.test:rules:1.4.0')

    //corputines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("com.google.code.gson:gson:2.8.6")

    //dagger
    //dagger2
    api 'com.google.dagger:dagger:2.35.1'
    api 'com.google.dagger:dagger-android:2.35.1'
    api 'com.google.dagger:dagger-android-support:2.35.1'

    annotationProcessor 'com.google.dagger:dagger-compiler:2.35.1'
    kapt 'com.google.dagger:dagger-compiler:2.35.1'

    annotationProcessor 'com.google.dagger:dagger-android-processor:2.35.1'
    kapt 'com.google.dagger:dagger-android-processor:2.35.1'

    compileOnly 'javax.annotation:jsr250-api:1.0'
    implementation 'javax.inject:javax.inject:1'


### Installing

* Download or fork from GitHub
* use API key from Marvel and add to local properties

### Executing program

* Download or fork from Github
* check depencencies
* run gradle

## Help

Any advise for common problems or issues.
```
brown.eugene@gmail.com
```

## Authors

Contributors names and contact info

ex. Eugene Brown  
ex. [@EugeneB](mailto:brown.eugene@gmail.com)

## Version History
* 0.1
    * Initial Release

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [Retrofit2](https://square.github.io/retrofit/)
* [Glide](https://bumptech.github.io/glide/)
* [Dagger2](https://dagger.dev/)
* [coroutines](https://developer.android.com)

