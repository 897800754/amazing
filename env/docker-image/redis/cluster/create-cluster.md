## 进入容器
docker exec -it cluster-redis-1 bash
## 建立集群

```shell

redis-cli --cluster create 172.20.96.1:6381 172.20.96.1:6382 172.20.96.1:6383 172.20.96.1:6384 172.20.96.1:6385 172.20.96.1:6386 --cluster-replicas 1


```