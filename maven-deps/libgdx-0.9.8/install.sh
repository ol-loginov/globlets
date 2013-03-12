#!/bin/bash

GROUP_OPTS="-DgroupId=libgdx -Dversion=0.9.8 -DgeneratePom=true"
JAR_OPTS="$GROUP_OPTS -Dpackaging=jar"

mvn install:install-file -Dfile=gdx.jar -Dsources=gdx-sources.jar $JAR_OPTS -DartifactId=gdx
mvn install:install-file -Dfile=gdx-natives.jar $JAR_OPTS -DartifactId=gdx-natives
mvn install:install-file -Dfile=gdx-backend-lwjgl-natives.jar $JAR_OPTS -DartifactId=gdx-backend-lwjgl-natives
mvn install:install-file -Dfile=gdx-backend-lwjgl.jar $JAR_OPTS -DartifactId=gdx-backend-lwjgl
mvn install:install-file -Dfile=gdx-backend-android.jar $JAR_OPTS -DartifactId=gdx-backend-android
