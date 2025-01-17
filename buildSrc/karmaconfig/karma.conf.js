// Set a fairly long test timeout because some tests in collection
// (specifically insertManyRemoveMany) occasionally take 20+ seconds to complete.
var testTimeoutInMs = 1000 * 30
// disconnect timeout should be longer than test timeout so we don't disconnect before the timeout
// is reported.
var browserDisconnectTimeoutInMs = testTimeoutInMs + 5000
config.set({
  // https://karma-runner.github.io/6.4/config/configuration-file.html
    browserDisconnectTimeout: browserDisconnectTimeoutInMs,
    processKillTimeout: testTimeoutInMs,
    concurrency: 10
})
config.set({
  client: {
    mocha: {
      timeout: testTimeoutInMs
    }
  }
})
