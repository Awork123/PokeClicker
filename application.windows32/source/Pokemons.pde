class Pokemons {
  int evolve = 0;
  int score = 0;

  int pokeBalls;
  int potions;
  int candy;

  int klikAmount;

  PImage basic, evolve1, evolve2;

  Pokemons() {
    evolve = 0;
    score = 0;
    pokeBalls = 0;
    potions = 0;
    candy = 0;
    klikAmount = 1;
  }

  void initPikachu () {
    basic = loadImage("Pikachu1.png");
    evolve1 = loadImage("Raichu1.png");
    evolve2 = loadImage("RetardPikachu.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  void initBulbasaur() {
    basic = loadImage("Bulbasaur1.png");
    evolve1 = loadImage("Ivysauer1.png");
    evolve2 = loadImage("Venusauer.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  void initCharmander() {
    basic = loadImage("charmander1.png");
    evolve1 = loadImage("Charmeleon.png");
    evolve2 = loadImage("Charizard.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  void initSquirtle () {
    basic = loadImage("Squirtle1.png");
    evolve1 = loadImage("Wartortle.png");
    evolve2 = loadImage("Blastoise.png");

    basic.resize(400, 400);
    evolve1.resize(400, 400);
    evolve2.resize(400, 400);
  }

  void display() {
    image(Baggrund, 0, 0);
    if (evolve == 0) { 
      image(basic, 400, 200);
    } else if  (evolve == 1) {
      image(evolve1, 400, 200);
    } else if (evolve == 2) {
      image(evolve2, 400, 200);
    }

    pokeballosv();
    if (score >= 20000) {
      if (evolve == 0) { 
        evolve = 1;
      }
    }
    if (score >= 40000) {
      if (evolve == 1) {
        evolve = 2;
      }
    }
  }


  void drawPokemon () {
    if (evolve == 0) { 
      image(basic, 0, 0);
    } else if  (evolve == 1) {
      image(evolve1, 0, 0);
    } else if (evolve == 2) {
      image(evolve2, 0, 0);
    }
  }
}
