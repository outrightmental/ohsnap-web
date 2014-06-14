package controllers

import play.api._
import play.api.mvc._

object Friend extends Controller {

  def index = Action {
    Ok(views.html.friend_index("Please select a friend."))
  }

  def view(attitude:String,id:String) = Action {
    Ok(views.html.friend_view(attitude,id))
  }

  def oppositeOf(attitude:String): String = if (attitude.equals("love")) { "hate" } else { "love" }

}