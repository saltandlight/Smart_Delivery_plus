/*

THREE COLOUR (FULL COLOUR) LED

Revised: 20th October 2018
By Seb Jensen

RED GOES TO D11
GREEN GOES TO D9
BLUE GOES TO D10
GROUND GOES TO GROUND

*/

int redpin = 8; //select the pin for the red LED
int bluepin =10; // select the pin for the  blue LED
int greenpin =9;// select the pin for the green LED
 
int val;
 
void setup() {
  Serial.begin(9600);
  while (!Serial) {
      ; // wait for serial port to connect. Needed for Leonardo only
    }
  pinMode(redpin, OUTPUT);
  pinMode(bluepin, OUTPUT);
  pinMode(greenpin, OUTPUT);
  Serial.begin(9600);
}
 
void loop() 
{
for(val=255; val>0; val--)
  {
   analogWrite(11, 255);
   analogWrite(10, 0-val);
   analogWrite(9, 0-val);
   delay(1); 
  }
for(val=0; val<255; val++)
  {
   analogWrite(11, 255);
   analogWrite(10, 0-val);
   analogWrite(9, 0-val);
   delay(1); 
  }
 Serial.println(val, DEC);
}
