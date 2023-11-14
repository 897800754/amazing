##启动dashboard
nohup java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar  > dashboard.log &
echo "启动 dashboard 成功"
