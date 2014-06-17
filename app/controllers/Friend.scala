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
          Module("kiss", "Love knows no boundaries!", "kiss-love.jpg"),
          Module("horse", "Get it girl!", "horse-love.jpg")
        )

      } else {
        // Hate Friend 1 "Lisa"
        Array(
          Module("stable", "bet you fuckin live in there", "stable-hate.gif"),
          Module("kiss", "Sounds like a dumb as balls story", "kiss-hate.jpg"),
          Module("horse", "ugggghhhhhhhh", "horse-hate.png")
        )

      }

    } else {
      // Friend 2 "Dave"

      if (attitude.equals("love")) {
        // Love Friend 2 "Dave"
        Array(
          Module("volunteer", "Cares about his community!", "volunteer-love.jpg"),
          Module("harvard", "Worked hard to get into a good school.", "harvard-love.jpg"),
          Module("nasa", "Practically achieving the American dream by being an astronaut", "nasa-love.jpg")
        )

      } else {
        // Hate Friend 2 "Dave"
        Array(
          Module("volunteer", "only volunteering for the pussy", "volunteer-hate.jpg"),
          Module("harvard", "Didn't Harvard just come out with a study that everyone there SUCKS?!!?", "harvard-hate.gif"),
          Module("nasa", "No way this fucker didn't cheat his way into space", "nasa-hate.jpg")
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

    arr.foreach(x => sb.append("<div class=\"block col-xs-6 col-sm-3 col-md-2\">" +
      "<p class=\"headline\">" + x.keyword + "</p>" +
      "<img src=\"/assets/images/friends/" + x.image_filename + "\" />" +
      "<p class=\"text\">" + x.text + "</p>" +
      "</div>"))

    sb.toString()
  }

}

case class Module(keyword: String, text: String, image_filename: String)