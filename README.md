# Sistema RPG com Padrão Observer

## Visão geral

Este projeto aplica o padrão **Observer** para monitorar e reagir às mudanças do estado de um personagem de RPG. O personagem (Subject) mantém uma lista de observadores (Observers) que são automaticamente notificados quando seu estado muda.

## Estrutura do projeto

- **Subject:** Interface que define métodos para registrar, remover e notificar observadores.
- **Observer:** Interface para os objetos que recebem atualizações.
- **Character:** Implementa Subject e gerencia estado do personagem (vida, mana, status de envenenado).
- **Observadores:**  
  - **UIObserver:** Atualiza a interface do usuário com o estado do personagem.  
  - **LogObserver:** Registra logs de mudanças de estado.  
  - **EnemyObserver:** Modifica comportamento dos inimigos baseado no estado do personagem.  
  - **AchievementObserver:** Desbloqueia conquistas com base em condições do personagem.

## Aplicação do padrão Observer

O padrão Observer facilita o desacoplamento entre o personagem e os componentes que precisam reagir às suas mudanças. Ao invés de o personagem conhecer detalhes de todos os interessados, ele apenas notifica os observadores que implementam a interface.

Isso torna o sistema flexível e extensível: para adicionar um novo comportamento reativo, basta criar um novo observador e registrá-lo no personagem.

## Fluxo de funcionamento

- Quando o personagem sofre danos, cura, usa mana ou altera status, ele chama `notifyObservers()`.
- Cada observador executa seu método `update()` recebendo o personagem como parâmetro, podendo consultar seu estado e reagir apropriadamente.
- Por exemplo, o `EnemyObserver` faz os inimigos fugirem quando a vida está baixa, e o `AchievementObserver` desbloqueia conquistas quando certas condições são atendidas.

## Testes

- Os testes usam JUnit 5 para garantir que:  
  - Os observadores são notificados corretamente nas mudanças de estado.  
  - Cada observador reage como esperado (atualização da UI, logs, comportamento inimigo, conquistas).  
  - Estados limites como vida baixa e envenenamento são tratados.  
  - O sistema funciona corretamente desde o estado inicial do personagem.

## Como executar

- Separe as classes em arquivos `.java` conforme indicado.  
- Compile e execute a classe `Main` para obter uma lista de strings com as atualizações dos observadores, para uso em testes ou exibição.  
- Rode os testes JUnit para validar o comportamento.

## Possíveis melhorias

- Adicionar mais observadores para outros sistemas do jogo (como sistemas de som, efeitos visuais, IA avançada).  
- Permitir que observadores escolham quais eventos observar (filtragem de notificações).  
- Criar eventos específicos para mudanças diferentes ao invés de uma notificação geral.
