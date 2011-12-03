import org.scalatra._
import java.net.URL
import scalate.ScalateSupport
import com.github.timgilbert.randomcover.Cover
import com.github.timgilbert.randomcover.TestCoverFactory
import com.github.timgilbert.randomcover.InMemoryStore

class CoverScalatraServlet extends ScalatraServlet with ScalateSupport {

  val covers = new InMemoryStore()
  val coverFactory = new TestCoverFactory()
  
  val views = "/WEB-INF/views/"
  
  // I'm not entirely sure why this incantation seems to be necessary, but at some point 
  // everything suddenly started to render as text/plain and this was the only thing 
  // that got it working again
  before() {
      contentType = "text/html"
      pass()
  }
  
  get("/") {
    val model = Map("allCovers" -> covers.list)
    
    templateEngine.layout(views + "index.jade", model)
  }
  
  get("/cover/:id") {
    covers.get(params("id")) match {
      case Some(cover) => templateEngine.layout(views + "cover.jade", Map("cover" -> cover))
      case None => templateEngine.layout(views + "notfound.jade")
    }
    //templateEngine.layout(views + "cover.jade", Map("cover" -> covers.get(params("id"))))
  }
  
  get("/new") {
    val newCover = coverFactory.generate()
    covers.put(newCover)
    redirect("/cover/" + newCover.id)
  }
}
