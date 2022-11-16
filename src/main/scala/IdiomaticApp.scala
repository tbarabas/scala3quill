import io.getquill.*
import io.getquill.cassandrazio.Quill
import zio.Console.printLine
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault, ZLayer}

object Main extends ZIOAppDefault:
  import IdiomaticAppData.*

  override def run: ZIO[Environment & ZIOAppArgs & Scope, Any, Any] =
    ( for {
      people <- DataService.getPeople()
      joes <- DataService.getPeopleByName("Joe")
      _ <- printLine(s"Joes: ${joes}")
    } yield ())
      .provide(
        Quill.CassandraZioSession.fromPrefix("testStreamDB"),
        Quill.Cassandra.fromNamingStrategy(Literal),
        QueryService.live,
        DataService.live
      )
      //.tapError(e => ZIO.succeed(println(s"Error Occurred: ${e}")))
      //.exitCode