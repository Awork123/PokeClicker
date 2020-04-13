
void valg() {
  if (side == 6) {
    stroke(255);
    noFill();
    stroke(225);
    image(Baggrund, 0, 0);
    line(0, height/2, width, height/2);
    line(width/2, 0, width/2, height);
    pushMatrix();
    translate( 100, 0);
    pokemons.get(0).drawPokemon();
    popMatrix();

    pushMatrix();
    translate( 700, 0);
    pokemons.get(1).drawPokemon();
    popMatrix();

    pushMatrix();
    translate( 100, 400);
    pokemons.get(2).drawPokemon();
    popMatrix();

    pushMatrix();
    translate( 700, 400);
    pokemons.get(3).drawPokemon();
    popMatrix();

    image(Back, 1130, 0);
  }
}

void tilbage () {
  if (mousePressed) {
    if (mouseX >1130 && mouseX <1130+70 && mouseY>0 && mouseY <0+70) {
      side =5;
    }
  }
}

void startside () {
  if (side==5) {
    image(Baggrund, 0, 0);
    stroke(0);
    fill(0);
    rect(400, 255, 400, 200);
    textSize(72);
    fill(255);
    textAlign(CENTER);
    text("START", width/2, height/2-20);
    image(PokeClicker, 300, 30);

    textSize(22);
    fill(255);
    textAlign(LEFT);

    text("- Vælg den Pokemon, som du godt kunne tænke dig!", 50, 675);
    text("- Klik på Pokemonen for at optjene points til opgraderinger!", 50, 700);
    text("- Evolves ved hver 20000 points!", 50, 725);
    fill(0);

    //startknappen-------
    if (mousePressed) {
      if (mouseX>400 && mouseX <400+400 && mouseY > 255 && mouseY < 255+200) {
        side=6;
        lastTime = millis();
      }
    }
  }
}

void pokeballosv() {
  image(Back, 1130, 0);
  image(PokeBall, 200, 650);
  image(Potion, 400, 650);
  image(Candy, 600, 650);
  textAlign(LEFT);


  textSize(32);
  fill(243, 250, 48);
  text("20", 215, 750);
  text("500", 400, 750);
  text("5000", 590, 750);
  textAlign(CENTER);
  noFill();
  image(PokeBall, 10, 0);
  image(Potion, 10, 80);
  image(Candy, 10, 160);

  fill(0);
  text(pokemons.get(side-1).pokeBalls, 130, 45);
  text(pokemons.get(side-1).potions, 130, 125);
  text(pokemons.get(side-1).candy, 130, 205);

  if (side < 5) {
    textSize(30);
    fill(0);
    textAlign(CENTER, TOP);
    if (pokemons.get(side-1).score < 999999999) {
      text(pokemons.get(side-1).score, 600, 100);
    }
  }
}
