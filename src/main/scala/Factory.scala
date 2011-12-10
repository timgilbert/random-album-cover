package com.github.timgilbert.randomcover

import scala.util.Random

trait CoverFactory {
  def generate(): Cover
}

class FixedTestCoverFactory extends CoverFactory {
  def generate(): Cover = {
    new Cover(id = "test", artist = "test artist", name = "test name", image = "")
  }
}

class RandomTestCoverFactory extends CoverFactory {
  private def tag(prefix: String = "") = prefix + (Random.alphanumeric take 10 mkString)
  def generate(): Cover = {
    new Cover(id = tag("id_"), artist = tag("random artist "), name = tag("random name "), image = "")
  }
}

trait QuoteFactory {
  def get(): String
}

class TestQuoteFinder {
  def get() = ""
}