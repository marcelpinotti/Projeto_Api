INSERT INTO tb_categorias (`id`, `tecnologia`, `turma`) VALUES ('1', 'Java', '1-2022');
INSERT INTO tb_categorias (`id`, `tecnologia`, `turma`) VALUES ('2', '.Net', '1-2022');

INSERT INTO tb_perfis (`id`, `nome`) VALUES ('1', 'Admin');
INSERT INTO tb_perfis (`id`, `nome`) VALUES ('2', 'Usuario');

INSERT INTO tb_starters (`nome`, `cpf`, `quatro_letras`, `email`, `categoria`) VALUES ('Marcel', '90972596062', 'MOVI', 'marcel@gmail.com', '1');
INSERT INTO tb_starters (`nome`, `cpf`, `quatro_letras`, `email`, `categoria`) VALUES ('Viviane', '02057896099', 'VIVI', 'viviane@gmail.com', '1');
INSERT INTO tb_starters (`nome`, `cpf`, `quatro_letras`, `email`, `categoria`) VALUES ('Joao', '74419198001', 'JJOO', 'joao@gmail.com', '2');
INSERT INTO tb_starters (`nome`, `cpf`, `quatro_letras`, `email`, `categoria`) VALUES ('Maria', '14435635O11', 'MARA', 'maria@gmail.com', '2');
INSERT INTO tb_starters (`nome`, `cpf`, `quatro_letras`, `email`, `categoria`) VALUES ('Pedro', '82620153042', 'PEDR', 'pedro@gmail.com', '1');
INSERT INTO tb_starters (`nome`, `cpf`, `quatro_letras`, `email`, `categoria`) VALUES ('Marry', '63701559007', 'MARR', 'marry@gmail.com', '2');

INSERT INTO tb_usuarios (`id`, `login`,  `senha`,  `perfil` ) VALUES ('1', 'Admin','$2a$10$Ug59IAvTIfhUxGgo4NirPeLZ.1a3WX6sQckD31.c8uubM5TJh7zsS', '1');
INSERT INTO tb_usuarios (`id`, `login`,  `senha`,  `perfil` ) VALUES ('2', 'Usuario','$2a$10$H0e90hksafeh9vXFiw8r/.kA2EaIjinDNzN5aoPEipGBJeHx.Q0na', '2')