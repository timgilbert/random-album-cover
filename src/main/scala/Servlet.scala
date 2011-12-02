import javax.servlet.http._

class CoverServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) =
    resp.getWriter().print("Hello World!")
}
