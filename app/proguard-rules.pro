# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep line numbers for crash reporting
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep data model classes used by SharedPreferences / serialization
-keep class com.evolutions.app.data.models.** { *; }

# Keep EncryptedSharedPreferences and security crypto
-keep class androidx.security.crypto.** { *; }

# Keep Navigation component arguments
-keepnames class com.evolutions.app.ui.** { *; }

# Keep ViewBinding generated classes
-keep class com.evolutions.app.databinding.** { *; }

# Standard Android rules
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
