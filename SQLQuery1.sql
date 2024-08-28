create database Exotica_Travel
go

use Exotica_travel
go

drop table airlines

create table airlines
(
  AirlineCode char(4) primary key,
  AirlineName  varchar(50) not null,
  Price float
)

drop table cart
create table Cart
(
 CartID int primary key, 
 UserID varchar(25),
 Destination varchar(25), 
 Hotel varchar(25), 
 Days int, 
 Airline varchar(25), 
 Price float,
 startdate date,
 enddate date,
 status varchar(50),
 cancel_tour char(1),
 cancel_reason varchar(50)
)

alter table cart add  cancel_tour char(1) 
alter table cart add cancel_reason varchar(50)



drop table hotels

create table Hotels
(
 HotelCode char(4) primary key,
HotelName varchar(50) not null,
 Price float
)

drop table Location_Country

create table Location_Country
(
 LocationCode char(4) primary key,
Place varchar(50) not null, 
BasePrice float
)

drop table Registration

create table Registration
(
 emailID varchar(25) primary key,
userName varchar(50) not null, 

Password varchar(50) not null, 
Address varchar(150) not null, 
State varchar(25) not null, 
Country varchar(25) not null, 
GroupName varchar(25)
)

drop table payment

create table Payment
(
 emailid varchar(25) references registration,
 cartid int references cart,
 amount float ,
 paydate date,
 details varchar(50)
)

create table Cart_temp
(
  startdate date,
  enddate date
  )
select * from cart_temp





select * from registration
update registration set groupname='administrator'



select datediff(dd,startdate,enddate) from cart


-- trigger for updating days in cart table
go
create trigger cart_ins_days
on cart for insert
as
update cart set days=datediff(dd,i.startdate,i.enddate) from inserted i,cart c where c.cartid=i.cartid

go

select * from cart
select *, DATEDIFF(dd,getdate(),startdate) from cart where DATEDIFF(dd,getdate(),startdate)>1



select * from airlines
select * from hotels

select * from payment

select * from registration




