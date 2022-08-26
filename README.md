# Technogise-Apr-2021 

![Scala Workflow](https://github.com/leoamsbb/Technogise-Apr-2021/actions/workflows/scala.yml/badge.svg)

- [Tools](#tools)
- [Run Application](#run-application)
- [Running Tests](#running-tests)

## Tools
| Tech / Tools / Libraries | version |
| ---------- | ------- |
| sbt | 1.4.3 |
| Java | 1.8_0_202 |
| Scala | 2.13.5 |
| ScalaTest | 3.0.8 |

## Run Application
Command to execute in Terminal:
```
sbt run
```

Examples:
```
King D3
E3, C3, D4, D2, E4, E2, C4, C2

Process finished with exit code 0

---------------------------------------------

Bishop H3
F1, G2, C8, D7, E6, F5, G4

Process finished with exit code 0

---------------------------------------------

Pawn G4
H4

Process finished with exit code 0

```

## Running Tests
Command to execute in Terminal:
```
sbt test
```

# Heroku

- Reference for Actions CI Job for Heroku deployment: https://amdelamar.com/blog/scala-ci-cd-with-github-actions-and-heroku/
- Reference to run console: https://devcenter.heroku.com/articles/running-a-remote-sbt-console-for-a-scala-or-play-application

## Running the console on Heroku

1. Go to Heroku Console
2. Run command `heroku run bash`
3. Execute below command in bash:

```
<path to Heroku App> -main scala.tools.nsc.MainGenericRunner -usejavacp
```

4. Above command will start scala console.
5. Import the package where main class resides.
```
import com.github.leoamsbb.chess._
```
6. Call main method
```
Game.main(Array(""))
```
7. Provide input
```
King D5
```
8. It will list all possible moves for King when placed at D5 position.

### Possible Improvements
- This could be a scala play app so that I would be able to access using API.
