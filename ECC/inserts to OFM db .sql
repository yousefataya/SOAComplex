--select * from IMD_OFM_COMPOSITE_DEF
--select * from IMD_OFM_COMPOSITE_AUTH_MTRX_DF

Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values   ('CustomerSignInfo'   , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values  ('CustomerOldSignInfo' , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCOutwardPresentment' , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCExtendSessionRequest' , 'Y');

--new
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCPosting' , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('getProfileInfo' , 'Y');

-- 13/10/2018
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('GetShareholdersInfo' , 'Y');
-- 15/10/2018
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCExtendSessionRequest' , 'Y');

-- 24/10/2018
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCCAAccountRequest' , 'Y');

-- 27/11/2018
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCAutoReply' , 'Y');

-- 06/12/2018
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCPDCDelete' , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCPDCUpdate' , 'Y');

-- 08/12/2018
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCPDCADD' , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCPosting2' , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCPosting1' , 'Y');
Insert into IMD_OFM_COMPOSITE_DEF (COMPOSITE_NAME , DB_LOG) values ('ECCOutwardReply' , 'Y');

--***************************** 

Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('CustomerSignInfo', 'ECC' , '*' , '*' , '*');

Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('CustomerOldSignInfo', 'ECC' , '*' , '*' , '*');
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCOutwardPresentment', 'ECC' , '*' , '*' , '*');
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCExtendSessionRequest', 'ECC' , '*' , '*' , '*');
--new
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCPosting', 'ECC' , '*' , '*' , '*');

Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('getProfileInfo', 'CBS' , '*' , '*' , '*');

-- 13/10/2018
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('GetShareholdersInfo', 'CBS' , '*' , '*' , '*');

-- 15/10/2018
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCExtendSessionRequest', 'ECC' , '*' , '*' , '*');

-- 24/10/2018
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCCAAccountRequest', 'ECC' , '*' , '*' , '*');

-- 27/11/2018
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCAutoReply', 'ECC' , '*' , '*' , '*');

-- 06/12/2018
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCPDCDelete', 'ECC' , '*' , '*' , '*');
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCPDCUpdate', 'ECC' , '*' , '*' , '*');

-- 08/12/2018
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCPDCADD', 'ECC' , '*' , '*' , '*');

Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCPosting2', 'ECC' , '*' , '*' , '*');
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCPosting1', 'ECC' , '*' , '*' , '*');
Insert into IMD_OFM_COMPOSITE_AUTH_MTRX_DF (COMPOSITE_NAME , SOURCE_SYSTEM , SOURCE_IP_ADDRESS , TOKEN , USER_NAME)
values ('ECCOutwardReply', 'ECC' , '*' , '*' , '*');


