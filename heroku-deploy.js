const shell = require('shelljs')

function deployToHeroku() {
  if (!shell.which('heroku')) {
    shell.echo(
      colors.red.bold(
        'Sorry, this script requires Heroku. Please follow the installment procedure at https://heroku.com'
      )
    )
    shell.exit(0)
  } else {
    const herokuToken = shell.exec('heroku auth:token', { silent: true }).stdout

    if (!herokuToken && shell.exec('heroku login').code !== 0) {
      shell.echo('Error: Heroku login failed')
      shell.exit(1)
      return
    }

    if (shell.exec('heroku create').code !== 0) {
      shell.echo('Error: Heroku create project failed')
      shell.exit(1)
      return
    }

    if (shell.exec('git push heroku master').code !== 0) {
      shell.echo('Error: Heroku create project failed')
      shell.exit(1)
      return
    }

    shell.echo('Success! Application is deployed to Heroku!')
  }
}

deployToHeroku()
