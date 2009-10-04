#include "glue.h"

JNIEXPORT jint JNICALL Java_org_huys_dll_HelloJNI_widthInBits
  (JNIEnv *env, jclass thisClass, jint n)
{
    // equivalent C JNI reflection
    // Class theClass = Class.forName( "java.lang.Long" );

    jclass theClass = env->FindClass( "java/lang/Long" );

    jclass classClass = env->GetObjectClass( theClass );

    jmethodID mid = env->GetMethodID( classClass, "getConstructors",
                                     "()[Ljava/lang/reflect/Constructor;" );

    jarray constructorList = (jarray)env->CallObjectMethod( theClass, mid );

    return n+1;
}

