
library(Rserve)
Rserve()

work<-read.table("C:\\logging\\work.log", sep=",",stringsAsFactors = F, header = F)
#################상품별 주문량
library(ggplot2)
library(dplyr)
str(work)
is.na(work)
work<-na.omit(work)

work2 <-work %>% 
       group_by(V5) %>% 
        summarise(n=n())

ggplot(work, aes(x=V5))+
  theme(axis.text.x = element_text(angle = 20))+
  geom_bar(fill="dark blue")+
  labs(title="Product Order", x="상품", y="주문 수") 


##################날씨별 주문량
str(work)
x <- strsplit(work$V7, "C")
x<-unlist(x)
y<-x[seq(from = 2, to = length(x), by = 2)]
work$wea <- y
work
str(work3)
work<- work %>%
  filter(wea!="맑음 ")
work3 <- work %>% 
  group_by(wea) %>% 
  summarise(n=n())

ggplot(work, aes(x=wea))+
  geom_bar(fill="dark blue")+
  labs(title="날씨별 주문량", x="날씨", y="주문량") 



##################실시간 주문량
#work$V3<-format(work$V3, format="%Y:%m:%d:%H:%M:%S")  
str(work)  
work$V3<-as.Date(work$V3)

work5 <- work %>% 
        group_by(V3) %>% 
        summarise(order_price=sum(V6))

str(work5)
ggplot(data=work5, aes(x=V3, order_price))+
  geom_line()+
  labs(title="날짜별 주문량", x="날짜", y="주문량") 

cor.test(as.numeric(work5$V3), work5$order_price)


