package controllers

import play.api._
import play.api.mvc._

object Friend extends Controller {

  def index = Action {
    Ok(views.html.friend_index("Please select a friend."))
  }

  def view(attitude: String, id: String) = Action {

    val blocks = if (id.equals("1")) {
      // Friend 1 "Lisa"

      if (attitude.equals("love")) {
        // Love Friend 1 "Lisa"
        Array(
          Module("stable", "beautiful home for horsies!!", "stable-love.gif"),
          Module("kiss", "Love knows no boundaries!", "kiss-love.gif"),
          Module("horses", "Get it girl!", "horses-love.gif")
        )

      } else {
        // Hate Friend 1 "Lisa"
        Array(
          Module("stable", "bet you fuckin live in there", "stable-hate.gif"),
          Module("kiss", "Sounds like a dumb as balls story", "kiss-hate.gif"),
          Module("horses", "ugggghhhhhhhh", "horses-hate.gif")
        )

      }

    } else {
      // Friend 2 "Dave"

      if (attitude.equals("love")) {
        // Love Friend 2 "Dave"
        Array(
          Module("volunteer", "Cares about his community!", "volunteer-love.gif"),
          Module("harvard", "Worked hard to get into a good school.", "harvard-love.gif"),
          Module("nasa", "Practically achieving the American dream by being an astronaut", "nasa-love.gif")
        )

      } else {
        // Hate Friend 2 "Dave"
        Array(
          Module("volunteer", "only volunteering for the pussy", "volunteer-hate.gif"),
          Module("harvard", "Didn't Harvard just come out with a study that everyone there SUCKS?!!?", "harvard-hate.gif"),
          Module("nasa", "No way this fucker didn't cheat his way into space", "nasa-hate.gif")
        )

      }

    }

    Ok(views.html.friend_view(attitude, id, blocks))
  }

  def oppositeOf(attitude: String): String = if (attitude.equals("love")) {
    "hate"
  } else {
    "love"
  }

  def writeBlocks(arr: Array[Module]) = {
    val sb = new StringBuilder()

    arr.foreach(x => sb.append("<div class=\"col-xs-6 col-sm-3 col-md-2\">" +
      "<h1>" + x.keyword + "</h1>" +
      "<img src=\"/assets/images/friends/" + x.image_filename + "\" />" +
      "<h2>" + x.text + "</h2>" +
      "</div>"))

    sb.toString()
  }

}

case class Module(keyword: String, text: String, image_filename: String)