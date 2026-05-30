create database event_management;
use event_management;
create table Users(user_id integer primary key auto_increment,
full_name varchar(100) not null,
email varchar(100) unique not null,
city varchar(100) not null,
registration_date date not null);
desc Users;
create table Events (event_id integer primary key auto_increment,
title varchar(200) not null,
description text,city varchar(100) not null,
start_date datetime not null, end_date datetime not null,
status enum('upcoming','completed','cancelled'),
organizer_id integer, foreign key(organizer_id) references Users(user_id));
desc Events;
create table Sessions (session_id integer primary key auto_increment, event_id integer,
title varchar(200) not null,
speaker_name varchar(100) not null,
start_time datetime not null, end_time datetime not null, foreign key(event_id) references Events(event_id));
desc Sessions;
create table Registrations (registration_id integer primary key auto_increment,
user_id integer,
event_id integer,
registration_date date not null,
foreign key(user_id) references Users(user_id), foreign key(event_id) references Events(event_id));
desc Registrations;
create table Feedback (feedback_id integer primary key auto_increment, user_id integer,
event_id integer,
rating integer check(rating between 1 and 5),
comments text,
feedback_date date not null,
foreign key(user_id) references Users(user_id),
foreign key(event_id) references Events(event_id));
desc Feedback;
create table Resources (resource_id integer primary key auto_increment,
event_id integer,
resource_type enum('pdf', 'image','link'),
resource_url varchar(255) not null,
uploaded_at datetime not null,
foreign key(event_id) references Events(event_id));
desc Resources;
insert into Users(full_name, email,city, registration_date) values('Alice Johnson','alice@example.com', 'New York', '2024-12-01'),
('Bob Smith' , 'bob@example.com' , 'Los Angeles' , '2024-12-05'),
('Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
('Diana King', 'diana@example.com', 'New York', '2025-01-15'),
('Ethan Hunt', 'ethan@example.com', 'Los Angeles' , '2025-02-01');
select * from Users;
insert into Events(title,description, city, start_date, end_date, status, organizer_id) values('Tech Innovators Meetup' , 'A meetup for tech enthusiasts' , 'New York' , '2025-06-10 10:00:00', '2025-06-10 16:00:00','upcoming', 1 ),
('AI & ML Conference' , 'Conference on AI & ML advancements' , 'Chicago' , '2025-05-15 09:00:00', '2025-05-15 17:00:00','completed', 2) ,
('Frontend Development Bootcamp' , 'Hands-on training on frontend tech' , 'Los Angeles' , '2025-07-01 10:00:00', '2025-07-03 16:00:00','upcoming', 3);
select * from Events;
insert into Sessions(event_id, title, speaker_name, start_time, end_time) values(1,'Opening Keynote' , 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(1,'Future of Web Dev' , 'Alice Johnson' ,'2025-06-10 11:15:00', '2025-06-10 12:30:00') ,
(2,'AI in Healthcare' , 'Charlie Lee' ,'2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(3,'Intro to HTML5' , 'Bob Smith' ,'2025-07-01 10:00:00', '2025-07-01 12:00:00');
select * from Sessions;
insert into Registrations(user_id, event_id, registration_date) values(1,1,'2025-05-01'),
(2,1,'2025-05-02'),
(3,2,'2025-04-30'),
(4,2,'2025-04-28'),
(5,3,'2025-06-15');
select * from Registrations;
insert into Feedback(user_id, event_id, rating, comments, feedback_date) values(3,2,4,'Great Insights!','2025-05-16'),
(4,2,5,'Very Informative.','2025-05-16'),
(2,1,3,'Could be better.','2025-06-11');
select * from Feedback;
insert into Resources(event_id,resource_type,resource_url, uploaded_at) values(1,'pdf','https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2,'image','https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3,'link','https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');
select * from Resources;

select u.full_name, e.title, e.city, e.start_date 
from Users u join Registrations r on u.user_id = r.user_id
join Events e on r.event_id = e.event_id 
where e.status = 'upcoming' 
and u.city = e.city 
order by e.start_date;

select e.event_id,e.title,
avg(f.rating) as average_rating,
count(f.feedback_id) as feedback_count
from events e
join feedback f
on e.event_id = f.event_id
group by e.event_id, e.title
having count(f.feedback_id) >= 10
order by average_rating desc;

select *
from users
where user_id not in (
    select user_id
    from registrations
    where registration_date >= curdate() - interval 90 day
);

select e.title,
count(s.session_id) as session_count
from events e
join sessions s
on e.event_id = s.event_id
where time(s.start_time) between '10:00:00' and '12:00:00'
group by e.event_id, e.title;

select u.city,
count(distinct r.registration_id) as total_registrations
from users u
join registrations r
on u.user_id = r.user_id
group by u.city
order by total_registrations desc
limit 5;

select e.title,
count(r.resource_id) as total_resources
from events e
left join resources r
on e.event_id = r.event_id
group by e.event_id, e.title;

select u.full_name,e.title,f.rating,f.comments
from feedback f
join users u
on f.user_id = u.user_id
join events e
on f.event_id = e.event_id
where f.rating < 3;

select e.title,
count(s.session_id) as total_sessions
from events e
left join sessions s
on e.event_id = s.event_id
where e.status = 'upcoming'
group by e.event_id, e.title;

select u.full_name as organizer_name,
e.status,count(e.event_id) as total_events
from users u
join events e
on u.user_id = e.organizer_id
group by u.full_name, e.status;

select e.title
from events e
join registrations r
on e.event_id = r.event_id
left join feedback f
on e.event_id = f.event_id
where f.feedback_id is null
group by e.event_id, e.title;

select registration_date,
count(user_id) as new_users
from users
where registration_date >= curdate() - interval 7 day
group by registration_date
order by registration_date;

select e.title,
       count(s.session_id) as total_sessions
from events e
join sessions s
on e.event_id = s.event_id
group by e.event_id, e.title
having count(s.session_id) = (
    select max(session_count)
    from (
        select count(session_id) as session_count
        from sessions
        group by event_id
    ) as temp
);

select e.city,
       avg(f.rating) as average_rating
from events e
join feedback f
on e.event_id = f.event_id
group by e.city;

select e.title,
count(r.registration_id) as total_registrations
from events e
join registrations r
on e.event_id = r.event_id
group by e.event_id, e.title
order by total_registrations desc
limit 3;

select s1.event_id,
s1.title as session1,
s2.title as session2
from sessions s1
join sessions s2
on s1.event_id = s2.event_id
and s1.session_id < s2.session_id
and s1.start_time < s2.end_time
and s1.end_time > s2.start_time;

select *
from users
where registration_date >= curdate() - interval 30 day
and user_id not in (
    select user_id
    from registrations
);

select speaker_name,
count(session_id) as total_sessions
from sessions
group by speaker_name
having count(session_id) > 1;

select e.title
from events e
left join resources r
on e.event_id = r.event_id
where r.resource_id is null;

select e.title,
count(distinct r.registration_id) as total_registrations,
avg(f.rating) as average_rating
from events e
left join registrations r
on e.event_id = r.event_id
left join feedback f
on e.event_id = f.event_id
where e.status = 'completed'
group by e.event_id, e.title;

select u.full_name,
count(distinct r.event_id) as events_attended,
count(distinct f.feedback_id) as feedbacks_submitted
from users u
left join registrations r
on u.user_id = r.user_id
left join feedback f
on u.user_id = f.user_id
group by u.user_id, u.full_name;

select u.full_name,
count(f.feedback_id) as total_feedbacks
from users u
join feedback f
on u.user_id = f.user_id
group by u.user_id, u.full_name
order by total_feedbacks desc
limit 5;

select user_id,event_id,
count(*) as duplicate_count
from registrations
group by user_id, event_id
having count(*) > 1;

select month(registration_date) as month,
       year(registration_date) as year,
       count(registration_id) as total_registrations
from registrations
where registration_date >= curdate() - interval 12 month
group by year(registration_date),
         month(registration_date)
order by year, month;

select e.title,
       avg(timestampdiff(minute,
           s.start_time,
           s.end_time)) as average_duration_minutes
from events e
join sessions s
on e.event_id = s.event_id
group by e.event_id, e.title;

select e.title
from events e
left join sessions s
on e.event_id = s.event_id
where s.session_id is null;
