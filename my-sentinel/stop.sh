# 检查参数是否为空

java_project_names=("sentinel-dashboard" "my-sentinel-server")

# 遍历数组，查找并杀死进程
for project_name in "${java_project_names[@]}"; do
  # 查找进程PID
  pid=$(pgrep -fl "$project_name" | grep -v "$0" | awk '{print $1}')

  # 检查是否找到进程
  if [ -z "$pid" ]; then
    echo "找不到与 $project_name 相关的Java进程"
  else
    # 安全地杀死进程
    kill -TERM "$pid"
    echo "Java进程 $project_name 已安全终止"
  fi
done
