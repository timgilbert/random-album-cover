// Defines a store for covers
// Inspiration from https://github.com/ny-scala/collabdraw/blob/master/src/main/scala/storage.scala

package com.github.timgilbert.randomcover

case class Cover(id: String, artist: String, name: String, image: String)

trait CoverStore {
  def get(id: String): Option[Cover]
  def list: Traversable[Cover]
  def put(cover: Cover): Cover
}

class InMemoryStore extends CoverStore {
  private val store = collection.mutable.Map[String, Cover]()
  
  def get(id: String): Option[Cover] = store.get(id)
  def list: Traversable[Cover] = store.values
  def put(c: Cover): Cover = { 
    store += (c.id -> c)
    c
  }
}