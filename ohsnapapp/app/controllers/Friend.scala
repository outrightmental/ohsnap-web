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
  def method(arr: Array[Module]) = {
    val sb = new StringBuilder();
    arr.foreach( x => sb.append( "<div class=\"col-sm-6 col-md-3\">" +  
            "<h1>" + x.keyword + "</h1>" +
            "<img src=\"/assets/images/friends/stable-love.gif\" />" +
            "<h2>"+x.text+"</h2>" +
        "</div>"));
    sb.toString;
  }

  
}

case class Module(keyword: String, text: String)