mvn clean package -Dmaven.test.skip=true
##启动dashboard
nohup java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar  > dashboard.log &
echo "启动 dashboard 成功"
##启动限流目标服务
nohup java -Dcsp.sentinel.dashboard.server=localhost:8080 \
-Dproject.name=my-sentinel-server  -Dcsp.sentinel.api.port=8088 -jar  ./my-sentinel-server/target/my-sentinel-server.jar > sentinel.log &
echo "启动 my-sentinel-server 成功"
