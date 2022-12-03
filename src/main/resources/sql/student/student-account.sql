# 创建学生账号信息表
drop table if exists `student_account`;
CREATE TABLE `student_account`
(
    `id`          int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生学号（账号）',
    `name`        varchar(12)      NOT NULL COMMENT '学生姓名',
    `pass_word`   varchar(16)      NOT NULL COMMENT '学生账号密码',
    `phone`       varchar(11)      NOT NULL COMMENT '学生手机号',
    `id_card`     varchar(18)      NOT NULL COMMENT '学生身份证',
    `email`       varchar(128)     NOT NULL COMMENT '学生邮箱',
    `valid`       tinyint(1)       NOT NULL DEFAULT '0' COMMENT '是否有效（0-无效,1-有效）',
    `create_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2022110001
  DEFAULT CHARSET = utf8mb4 COMMENT ='学生账号信息表';

# 测试数据
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('宋浩然', 'qI3Zey4Q', '17517069474', '110842199812080483', 'liza.stracke@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('何弘文', 'Np4o37Zt', '18352731487', '57580719961016865X', 'marty.cummings@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('方思', '6BWU15JP', '15916770107', '58802519930631449X', 'winston.abshire@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('陆鸿煊', 'nBran8g0', '15822266333', '129931199901015930', 'connie.osinski@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('孙黎昕', 'QerwQ6R7', '17124468246', '550381199311039817', 'hobert.jacobi@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('李炎彬', '1hmlxgHx', '17733062911', '67653219941205538X', 'rickey.lakin@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('沈志泽', 'iC1q443D', '17839733458', '360263199305102505', 'desmond.waelchi@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('梁振家', '05CNJ87M', '15876412769', '17933019920420507X', 'ken.kertzmann@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('龚擎宇', 'MB07M2Ic', '13538534627', '15089619980225583X', 'davis.jast@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('邹雨泽', '8Jg4Q167', '14750131104', '26359719960509574X', 'franklin.lakin@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('何驰', '20B6Gc7e', '18664443348', '551749199503035090', 'luke.lang@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('雷伟泽', 'o9vSGjuc', '15561977253', '699591199506318425', 'estrella.haley@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('莫语堂', '2812h2kZ', '17501353700', '29894119901230696X', 'maryetta.koelpin@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('万炎彬', 'lMtd3x09', '17395557197', '437638199101311575', 'rosemarie.rolfson@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('赵越彬', 'PtX5h1We', '15517863009', '12239219920701627X', 'dominick.veum@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('贺哲瀚', 'Z2R3gnDw', '14724010512', '51808419940921352X', 'babara.schroeder@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('贾聪健', 'Za6B649g', '15979899699', '34165519910431526X', 'theron.effertz@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('何修洁', 'h8lZfkN3', '15799965764', '585804199901018135', 'jim.kovacek@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('吴立诚', '7G1Wq1Xq', '15728838830', '517163199111152797', 'glenn.stehr@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('叶越彬', 'NVnxftco', '15032085475', '57111119951031726X', 'cornell.tillman@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('万昊然', 'fh7G3x77', '15107840498', '245956199412309566', 'kim.hagenes@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('邵涛', '6FCXiAXJ', '17263481415', '55053319901115575X', 'ezequiel.schiller@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('白皓轩', 'yd20DHrm', '15206658681', '398135199106306464', 'willard.jacobi@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('韦晟睿', 'SH4QaFj4', '15092183786', '26127719960504959X', 'lucinda.haag@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('徐鹏飞', '8ZN8yL9R', '18816487226', '16077119960609166X', 'roscoe.rolfson@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('尹绍齐', 'EdDDJDHF', '15220691296', '54166619961118658X', 'paz.medhurst@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('冯伟宸', '3EA3iDEI', '17650546979', '229622199210077730', 'jerrie.nolan@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('尹健柏', '64885nBL', '15513645655', '66198519900906011X', 'sal.paucek@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('熊哲瀚', '5U2t5cpT', '15755360997', '644167199011104524', 'elmer.yundt@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('邵昊天', 'iZ4Xe3a8', '15127528250', '64017819961030914X', 'ardath.greenholt@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('任煜祺', 'O92e19J8', '15949089195', '54782419940601578X', 'eldridge.effertz@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('郝哲瀚', 'ajKK7Wo4', '17311973968', '569070199208014071', 'fredric.kerluke@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('黎昊天', 'YMAfK0jL', '13582913523', '59011919900709042X', 'margie.johnston@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('梁浩', 'Ah9qO9ce', '15774720612', '21582419960603853X', 'deon.klocko@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('贺博涛', '96xeA7cI', '17835798696', '411443199711024317', 'nelson.daugherty@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('龙越彬', '4b2cu4aR', '17852803197', '25566019961113324X', 'kelvin.welch@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('丁子轩', '9VdAd13c', '15247698411', '231109199212072138', 'delphine.nienow@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('傅弘文', 'Sf4qVBdL', '14545634491', '689155199910319350', 'arturo.collins@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('侯烨华', 'eSaX4fwJ', '13079218011', '533720199612051617', 'daren.bode@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('龚明轩', 'WV3oPnGK', '15921913121', '57791719931116210X', 'lelia.bogan@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('覃炎彬', '0MR713bN', '14751637211', '568627199808053660', 'harold.goyette@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('龚峻熙', 'kGk59VE8', '18728954532', '32871219910302664X', 'augustine.white@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('陈笑愚', '9Jh37C1X', '15769923803', '689281199109180342', 'bianca.bernhard@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('熊彬', '50Dh995M', '15882548746', '63020419930405424X', 'vera.wiegand@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('曾哲瀚', '8qbC27I8', '17618963411', '64663319991102693X', 'marcela.rosenbaum@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('方烨华', 'Zm3cw6jz', '17578463392', '441108199209306868', 'phylis.veum@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('熊雨泽', 'OLe69MOE', '15529635731', '68161319910431463X', 'emmitt.altenwerth@hotmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('任烨磊', 'j7Wg33Av', '15615455021', '665284199111229080', 'keturah.schuppe@yahoo.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('段子骞', 'dCxDogM3', '17236155124', '47717619930620522X', 'karly.rutherford@gmail.com');
insert into `student_account` (`name`, `pass_word`, `phone`, `id_card`, `email`) values ('戴昊焱', 'jD3naqu2', '17708906407', '22926619961230252X', 'monroe.robel@hotmail.com');