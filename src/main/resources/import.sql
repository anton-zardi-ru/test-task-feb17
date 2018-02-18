insert into contact(contact_id) values('CONTACT 1')
insert into contact(contact_id) values('CONTACT 2')
insert into contact(contact_id) values('CONTACT 3')

insert into application(application_id, date_created, product_name, contact_id) values('APPLICATION 1', '2018-01-01 01:01:00+00', 'PRODUCT NAME 1', (select id from contact where contact_id = 'CONTACT 1'))
insert into application(application_id, date_created, product_name, contact_id) values('APPLICATION 2', '2018-02-02 02:02:00+00', 'PRODUCT NAME 2', (select id from contact where contact_id = 'CONTACT 1'))
insert into application(application_id, date_created, product_name, contact_id) values('APPLICATION 3', '2018-03-03 03:03:00+00', 'PRODUCT NAME 1', (select id from contact where contact_id = 'CONTACT 2'))
