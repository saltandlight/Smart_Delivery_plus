#include <DHT11.h>
int pin=7;
DHT11 dht11(pin); 
void setup()
{
   Serial.begin(9600);
  while (!Serial) {
      ; // wait for serial port to connect. Needed for Leonardo only
    }
}

void loop()
{
    Serial.write("Serial Avaiable");
    int err;
    float temp, humi;
    if((err=dht11.read(humi, temp))==0)
    {
      Serial.write("temperature : ");
      Serial.write(temp);
      Serial.write(humi);
      Serial.write("\n");
    }
    else
    {
      Serial.write(err);
    }
    delay(5000); //delay for reread  
}
