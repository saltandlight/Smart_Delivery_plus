#include <DHT11.h>

//THREE COLOUR (FULL COLOUR) LED
int redpin = 8; //select the D8pin for the red LED
int bluepin =9;// select the D9pin for the green LED
int greenpin =10; // select the D10pin for the  blue LED
//Specify digital pin on the Arduino that the positive lead of piezo buzzer is attached.
int buzzerPin = 11;
int temphumiPin=7;
DHT11 dht11(temphumiPin); 
void setup()
{
  Serial.begin(9600);
  while (!Serial) {
      ; // wait for serial port to connect. Needed for Leonardo only
      }
}

void loop()
{
  if(Serial.available()>0){
    int text = Serial.read();
    if(text=='l'){
     analogWrite(8,255);
     analogWrite(9,200);
     analogWrite(10,100);
     delay(1000);
     analogWrite(8,0);
     analogWrite(9,0);
     analogWrite(10,0);   
    }
    if(text=='b'){
      /*Tone needs 2 arguments, but can take three
      1) Pin#
      2) Frequency - this is in hertz (cycles per second) which determines the pitch of the noise made
      3) Duration - how long teh tone plays
      */
      tone(buzzerPin, 2000, 500);
      tone(buzzerPin, 500, 500);
      tone(buzzerPin, 2000, 500);
      tone(buzzerPin, 500, 500);  
    }
  }
  int err;  
  float temp, humi;
  if((err=dht11.read(humi, temp))==0)
  {
    Serial.print(String("temp ")+String(temp,0)+String(" humi ")+String(humi,0));
    }
  delay(2000); //delay for reread
}
