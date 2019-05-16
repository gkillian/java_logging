#!/bin/sh
BASEDIR=`pwd`
# LIBDIR=${BASEDIR}/target/dependency
CPDIR=${BASEDIR}/target/classes

# set classpath to use all JARS in the directory using --> ${LIBDIR}/*  (not "*.jar"!)
#set  CLASSPATH=${LIBDIR}/*:${CPDIR}:.
CLASSPATH=${LIBDIR}/*:${CPDIR}:.

if [ ! -r ${CPDIR}/gaknet/App.class ]; 
then
  echo "gaknet.App class files does not exists";
  exit 1; 
fi
# if [ ! -d  target/dependency ];
# then
#  echo "target/dependency does not exist";
#  exit 1;
# fi

cd target/classes && java -cp ${CLASSPATH} gaknet.App && cd ../..

