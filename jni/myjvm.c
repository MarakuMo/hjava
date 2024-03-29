#include <stdio.h>
#include <jni.h>

JNIEnv* create_vm() {
    JavaVM* jvm;
    JNIEnv* env;
    JavaVMInitArgs args;
    JavaVMOption options[2];

    int x;
    /* There is a new JNI_VERSION_1_4, but it doesn't add anything for the purposes of our example. */
    args.version = JNI_VERSION_1_2;
    args.nOptions = 2;
    /*
    options[0].optionString = "-Djava.class.path=/opt/devel/myjava/hjava";
    options[1].optionString = "-Djava.library.path=/opt/devel/myjava/hjava";
    */
    options[0].optionString = "-Djava.class.path=.:../hjava.jar";
    options[1].optionString = "-Djava.library.path=.";
    args.options = options;
    args.ignoreUnrecognized = JNI_FALSE;

    x = JNI_CreateJavaVM(&jvm, (void **)&env, &args);

    printf("x : %d\n", x);
    return env;
}

void invoke_class(JNIEnv* env) {
    jclass helloWorldClass;
    jmethodID mainMethod;
    jobjectArray applicationArgs;
    jstring applicationArg0;

    helloWorldClass = (*env)->FindClass(env, "org/huys/dll/HelloJNI");

    mainMethod = (*env)->GetStaticMethodID(env, helloWorldClass, "main", "([Ljava/lang/String;)V");

    applicationArgs = (*env)->NewObjectArray(env, 1, (*env)->FindClass(env, "java/lang/String"), NULL);
    applicationArg0 = (*env)->NewStringUTF(env, "From-C-program");
    (*env)->SetObjectArrayElement(env, applicationArgs, 0, applicationArg0);

    (*env)->CallStaticVoidMethod(env, helloWorldClass, mainMethod, applicationArgs);
}


int main(int argc, char **argv) {
    JNIEnv* env = create_vm();
    invoke_class( env );
}

