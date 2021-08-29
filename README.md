# SpringでPostgreSQLを使った時の単体テストのテスト

H2を使わない場合のテストのやり方がよくわからなかったので、試してみた。

## 設定

application.propertiesを実装とテスト用それぞれに用意

schema.sqlについては実装側のみに用意

テスト用データ投入スクリプトをtest側に用意

## 疑問点

- テストの中でjdbcTemplateを使った場合、本当にpostgreSQLに入っているのかよくわからない。

- テストでContextConfigurationを入れないとRepositoryのエラーになる



