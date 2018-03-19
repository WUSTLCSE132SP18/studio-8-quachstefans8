#include <Wire.h>
#include <SparkFun_MMA8452Q.h>
#define BUFF_SIZE 10

MMA8452Q accel;
int count = 0;
double buff[BUFF_SIZE][3];

void setup() {
  Serial.begin(9600);
  accel.init();
}

void loop() {
  if (accel.available()) {
    accel.read();
    double input[] = {accel.cx, accel.cy, accel.cz};
    for(int i=0; i<3; i++){
      buff[count%BUFF_SIZE][i] = input[i];
    }
    
    printCAccel();
    Serial.println();
  }
}

void printCAccel() {
  Serial.print(accel.cx, 3);
  Serial.print(",");
  Serial.print(accel.cy, 3);
  Serial.print(",");
  Serial.print(accel.cz, 3);
}

