package com.github.timgilbert.randomcover

trait CoverFactory {
  def generate(): Cover
}

class TestCoverFactory extends CoverFactory {
  def generate(): Cover = {
    new Cover(id = "test", artist = "test artist", name = "test name", image = "")
  }
}