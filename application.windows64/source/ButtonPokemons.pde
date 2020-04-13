void mousePressed() {
  if (side == 6) {
    if (millis() - lastTime > 500 ) {
      if (mouseX >0 && mouseX <0+600 && mouseY>0 && mouseY <0+400) {
        side =1;
      }

      if (mouseX >600 && mouseX <600+600 && mouseY>0 && mouseY <0+400) {
        side =2;
      }

      if (mouseX >0 && mouseX <0+600 && mouseY>400 && mouseY <400+400) {
        side =3;
      }

      if (mouseX >600 && mouseX <600+600 && mouseY>400 && mouseY <400+400) {
        side =4;
      }
    }
  }
}
