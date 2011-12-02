import org.scalatra._
import java.net.URL
import scalate.ScalateSupport
import com.github.timgilbert.randomcover.Cover
import com.github.timgilbert.randomcover.TestCoverFactory
import com.github.timgilbert.randomcover.InMemoryStore

class CoverScalatraServlet extends ScalatraServlet with ScalateSupport {

  val covers = new InMemoryStore()
  val coverFactory = new TestCoverFactory()

  get("/") {
    contentType="text/html"
    templateEngine.layout("/WEB-INF/views/index.jade")
  }
  
  get("/cover/:id") {
    val cover = covers.get(params("id"))
    
    contentType="text/html"
    templateEngine.layout("/WEB-INF/views/cover.jade")
  }
  
  get("/new") {
    val newCover = coverFactory.generate()
    covers.put(newCover)
    redirect("/cover/" + newCover.id)
  }
  
  /*
  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound() 
  }
  */
}
