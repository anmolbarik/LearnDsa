while true
do
  git add .
  git commit -m "auto commit - $(date)" || exit 0
  git push
  sleep 300
done