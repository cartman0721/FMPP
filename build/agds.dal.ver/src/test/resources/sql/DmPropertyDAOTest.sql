delete from AGDS_DM_PROPERTY where id=1;
insert into AGDS_DM_PROPERTY (
		ID
		,PATH_ID
		,PCODE
		,PNAME
		,DATA_TYPE
		,VALIDATOR
		,TAG
		,STATUS
		,DW_TABLE
		,DW_COLUMN
		,DESCS
		,CREATER
		,OPERATOR
		,GMT_CREATE
		,GMT_MODIFIED
		,IN_DATE
		,SUBMIT_DATE
		,UPD_FREQUENCY
		,TIMELINESS
		,PRIORITY
		)
	  values (
		1
		,1
		,'test'
		,'test'
		,1
		,'test'
		,1
		,1
		,'test'
		,'test'
		,'test'
		,'test'
		,'test'
				,sysdate()
				,sysdate()
				,sysdate()
				,sysdate()
		,'test'
		,'test'
		,'test'
	    );
