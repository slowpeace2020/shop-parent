###nacos启动
>cd /Users/shanchu/nacos/distribution/target/nacos-server-2.2.1-RC/nacos/bin
>sh startup.sh -m standalone

###sentinel启动
>启动命令：
>cd ~/Downloads 
>java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.6.jar 

###zipkin
>curl -sSL https://zipkin.io/quickstart.sh | bash -s
>java -jar zipkin.jar