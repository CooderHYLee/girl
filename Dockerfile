FROM maven:3.5.2-jdk-8-alpine

# 给你的应用建里一个放应用的工作目录
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# 将当前目录的的程序复制到工作目录下
COPY settings.xml /usr/share/maven/ref/
COPY . /usr/src/app

# 1.mvn-entrypoint.sh 是基层镜像的命令（maven的命令，打包成jar） 2.然后copy到统一放jar包的目录  3.程序运行起来；删除源码
RUN /usr/local/bin/mvn-entrypoint.sh mvn clean install \
     && cp -R ./target/*.jar ../app.jar \
     && rm -R /usr/src/app/ \
     && rm -R /usr/share/maven/ref/repository/


# 运行程序并暴露端口
CMD ["java", "-jar", "/usr/src/app.jar"]
EXPOSE 8088