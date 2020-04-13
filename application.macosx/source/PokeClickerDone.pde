import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

Minim minim;
AudioPlayer pokeSong;
AudioSample pikaSound;
AudioSample bulbasaurSound;
AudioSample charmanderSound;
AudioSample squirtleSound;

PImage Charmander, Pikachu, Bulbasaur, Squirtle, Raichu, Ivysauer, Venusauer, Blastoise, Charizard, Wartortle, Charmeleon, retardPikachu;
PImage PokeClicker, Back, Finger, Baggrund, PokeBall, Potion, Candy, Sky;

int side = 5; //startskærm
long lastTime = 0;
int antalPokeBall = 0;
int antalPotions = 0;
int antalCandy = 0;
int sideEvolve = 0;
boolean isPlaying = false;

ArrayList <Pokemons> pokemons = new ArrayList<Pokemons>();

void setup() {
  size(1200, 800);
  minim = new Minim(this);
  pokeSong = minim.loadFile("PokeSong.mp3");
  pokeSong.setGain(-35);
  pokeSong.play();
  pokeSong.loop();

  minim = new Minim(this);
  pikaSound = minim.loadSample("pikaSound.mp3", 512);
  bulbasaurSound = minim.loadSample("BulbasaurSound.mp3", 512);
  charmanderSound = minim.loadSample("CharmanderSound.mp3", 512);
  squirtleSound = minim.loadSample("SquirtleSound.mp3", 512);

  PokeClicker = loadImage("PokeClicker.png");
  Back = loadImage("back1.png");
  Baggrund = loadImage("baggrundstor.png");
  PokeBall = loadImage("PokeBall.png");
  Potion = loadImage("Potion.png");
  Candy = loadImage("Candy.png");

  PokeClicker.resize(600, 200);
  Back.resize(70, 70);
  Baggrund.resize(1200, 800);
  PokeBall.resize(70, 70);
  Potion.resize(70, 70);
  Candy.resize(70, 70);



  Pokemons pikachu = new Pokemons();
  pikachu.initPikachu();
  Pokemons bulbasaur = new Pokemons();
  bulbasaur.initBulbasaur();
  Pokemons charmander = new Pokemons();
  charmander.initCharmander();
  Pokemons squirtle = new Pokemons();
  squirtle.initSquirtle();

  pokemons.add(pikachu);
  pokemons.add(bulbasaur);
  pokemons.add(charmander);
  pokemons.add(squirtle);
}

void draw() {
  tilbage();

  if (side == 5) {
    startside();
  } else if (side == 6) {
    isPlaying = false;
    valg();
  } else if (side == 1) {
    if (!isPlaying && pokemons.get(0).evolve==0) {
      pikaSound.setGain(-25);
      pikaSound.trigger();
      isPlaying = true;
    }
    pokemons.get(0).display();
    
  } else if (side == 2) {
    if (!isPlaying && pokemons.get(1).evolve==0) {
      bulbasaurSound.setGain(-32);
      bulbasaurSound.trigger();
      isPlaying = true;
    }
    pokemons.get(1).display();
    
  } else if (side == 3) {
    if (!isPlaying  && pokemons.get(2).evolve==0) {
      charmanderSound.setGain(-22);
      charmanderSound.trigger();
      isPlaying = true;
    }
    pokemons.get(2).display();
    
  } else if (side == 4) {
    if (!isPlaying  && pokemons.get(3).evolve==0) {
      squirtleSound.setGain(-33);
      squirtleSound.trigger();
      isPlaying = true;
    }
    pokemons.get(3).display();
  }
 
}
