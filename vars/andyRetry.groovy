def call(retry, cmd) {
  def rc=0

  for(int i = 1; i <= retry; i++) {
    rc = sh(script: cmd, returnStatus: true)
    if(rc == 0) {
      break
    }
    echo "Attempt ${i} of ${retry} failed. Retrying"
  }

  if(rc != 0) {
    currentBuild.result = 'FAILED'
  }
}
