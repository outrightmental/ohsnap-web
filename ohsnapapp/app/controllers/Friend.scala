package controllers

import play.api._
import play.api.mvc._

object Friend extends Controller {

  def index = Action {
    Ok(views.html.friend_index("Please select a friend."))
  }

  def view(id:String) = Action {
    Ok(views.html.friend_view("Here is a picure of your friend " + id))
  }

}