### Vk-Bot

#
#### Описание проекта
Данный бот настроен на подключение к BotAPI VK. https://vk.com/dev/bots_docs и позволяет в очень упрощенном виде на обработку сообщений исходящих из сообщества.
В структуре программы предусмотренно разделение на несколько уровней для приема, обработки и высылки ответа на сообщения.
Создан интерфейс __Request Service__, который при желании развития данного бота и продумывания новой функциональности лего можно расширить существующий набор функций для обрабтки сообщений.



#
#### Подготовка к запуску
Для начала необходимо задать настройки в сообществе для подключения бота. Для этого следует перейти в __Управление сообществом > Сообщения > Настройки для бота__ и включить возможности ботов :white_check_mark:. 
Убедитесь что сообщения включены __Управление сообществом > Сообщения__  пункт __Включены__ .
После чего перейти в __Настройки > Работа с API__ и создать ключ доступа.

<p align="center">
  <img src="https://sun9-73.userapi.com/lNvab5lXhHNioTd2sGdiCLLO3ujWO2FyAbxXQg/-Qx0yU1eg5A.jpg" />
</p>

Далее перейти в Callback API добавить сервер, задать секретный ключ, установить желаемую версию VK API. 
<p align="center">
  <img src="https://sun9-58.userapi.com/poysy86AKc-ulzj2cPCcPbypqWShuqtD-BERug/ahvj8_GfTuQ.jpg" />
</p>
Теперь можно перейти к конфигурации.

#
#### Конфигурация

В __application.yml__ необходимо указать:

+ your.server.port - адрес вашего сервера.
+ your.version.vk.api - установленная версия VK API (дря работы VK Bot необходима версия выше 5.103).
+ your.confirmation.token - cтрока, которую должен вернуть сервер при добавлении сервера.
+ your.access.token - ключ доступа.
+ your.secret.key - секретный ключ обеспечитвает дополнительную защиту и проверку что уведомление пришло от VK API

```yml
server:
  connectionTimeout: -1
  port: ${your.server.port}
  servlet:
    context-path: /vk-chat-bot
api:
  vk:
    url: https://api.vk.com/method/
    version: ${your.version.vk.api}

token:
  confirmation:  ${your.confirmation.token}
  access: ${your.access.token}


secret:
  key: ${your.secret.key}
```


