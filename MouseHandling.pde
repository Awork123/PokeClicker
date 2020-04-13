void mouseReleased() {
  if (side < 5) {
    if (mouseX > 400 && mouseX < 400+400 && mouseY > 200 && mouseY <200+400) {
      pokemons.get(side-1).score += pokemons.get(side-1).klikAmount;
    }
  }

  if (mouseX > 200 && mouseX <200+70 && mouseY>650 && mouseY<650+70) {
    if (pokemons.get(side-1).score >19) {
      pokemons.get(side-1).score -= 20;
      pokemons.get(side-1).klikAmount += 1;
      pokemons.get(side-1).pokeBalls++;
    }
  }

  if (mouseX > 400 && mouseX <400+70 && mouseY>650 && mouseY<650+70) {
    if (pokemons.get(side-1).score >499) {
      pokemons.get(side-1).score -= 500;
      pokemons.get(side-1).klikAmount += 5;
      pokemons.get(side-1).potions++;
    }
  }


  if (mouseX > 600 && mouseX <600+70 && mouseY>650 && mouseY<650+70) {
    if (pokemons.get(side-1).score >4999) {
      pokemons.get(side-1).score -= 5000;
      pokemons.get(side-1).klikAmount += 30;
      pokemons.get(side-1).candy++;
    }
  }
}

/*
500/20 = 25

5000/20 = 250


*/
