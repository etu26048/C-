delete from schedules;
insert into schedules([StartHour]
           ,[Endhour]
           ,[Day]
           ,[Doctor_Id]
           ,[Postguard_Id]
           ,[Hospital_Id]
           ,[Drugstore_Id])
values(
	'9:00 AM',
	'12:00 PM',
	'Lundi',
	null,
	null,
	1,
	null
);

--insert into schedules([StartHour]
--           ,[Endhour]
--           ,[Day]
--           ,[Doctor_Id]
--           ,[Postguard_Id]
--           ,[Hospital_Id]
--           ,[Drugstore_Id])
--values(
--	'13:00 PM',
--	'17:00 PM',
--	'Lundi',
--	null,
--	null,
--	1,
--	null
--);

--insert into schedules([StartHour]
--           ,[Endhour]
--           ,[Day]
--           ,[Doctor_Id]
--           ,[Postguard_Id]
--           ,[Hospital_Id]
--           ,[Drugstore_Id])
--values(
--	'9:00 AM',
--	'12:00 PM',
--	'Lundi',
--	null,
--	null,
--	2,
--	null
--);
--select * from schedules;