delete from AGDS_DM_PATH where id=1;
insert into AGDS_DM_PATH (
		ID
		,PCODE
		,PNAME
		,PARENT_ID
		,DESCS
		,GMT_CREATE
		,GMT_MODIFIED
		,OPERATOR
		)
	  values (
		1
		,'test'
		,'test'
		,1
		,'test'
				,sysdate()
				,sysdate()
		,'test'
	    );
